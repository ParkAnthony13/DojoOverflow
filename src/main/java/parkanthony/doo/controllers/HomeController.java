package parkanthony.doo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import parkanthony.doo.models.Answer;
import parkanthony.doo.models.Question;
import parkanthony.doo.models.Tag;
import parkanthony.doo.services.AnswerService;
import parkanthony.doo.services.QuestionService;
import parkanthony.doo.services.TagService;

@Controller
public class HomeController {
	private final QuestionService questionService;
	private final AnswerService answerService;
	private final TagService tagService;
	
	public HomeController(QuestionService questionService,AnswerService answerService,TagService tagService) {
		this.questionService = questionService;
		this.answerService = answerService;
		this.tagService = tagService;
	}
	// sends home route to questions page
	@RequestMapping("/")
	public String landing() {
		return "redirect:/questions";
	}
	// questions page displays list of questions and its 0-3 tags in tags column
	@RequestMapping("/questions")
	public String questionPage(Model model) {
		List<Question> questions = questionService.allItems();
		model.addAttribute("questions", questions);
		return "/question/questionlist.jsp";
	}
	// creates a new question and must be able to add tags here as well.
	@RequestMapping("/questions/new")
	public String renderQuestion() {
		return "/question/newQuestion.jsp";
	}
	// display question and answers
	@RequestMapping("/questions/{id}")
	public String answerPage(@PathVariable("id") Long id,Model model) {
		Question question = questionService.findQuestion(id);
		model.addAttribute("question", question);
		return "/question/showQuestion.jsp";
	}
	// adding answers from the answerPage Post method
	@RequestMapping(value="/questions/{id}",method=RequestMethod.POST)
	public String addAnswertoQuestion(@PathVariable("id") Long id,
			@RequestParam("answer") String ans,
			RedirectAttributes redirectAttributes) {
		boolean validation = true;
		if(ans.equals("")) {
			redirectAttributes.addFlashAttribute("error","ANSWER IS REQUIRED");
			validation = false;
		}
		Question question = questionService.findQuestion(id);
		// create answer with string
		Answer newAnswer = new Answer(ans);
		newAnswer.setQuestion(question);
		Answer newnewAns = answerService.createItem(newAnswer);
//		List<Answer> test = question.getAnswers();
//		test.add(newnewAns);
//		question.getAnswers().add(newnewAns);
//		for(Answer anss:test) {
//			System.out.println(anss.getAnswer());
//		}
//		question.setAnswers(test);
//		questionService.updateItem(question);

		return "redirect:/questions/"+id;
	}
	// post route for creating new questions with tags
	@RequestMapping(value="/questions/new",method=RequestMethod.POST)
	public String createNewQuestion(@RequestParam("question") String question,
			@RequestParam("tags") String tags,
			RedirectAttributes redirectAttributes) {
		String[] tagger = tags.split(",");
		boolean validation = true;
		if (question.equals("")) {
			redirectAttributes.addFlashAttribute("errorQuestion","QUESTION IS REQUIRED");
			validation = false;
		}
		if (tags.equals("")) {
			redirectAttributes.addFlashAttribute("errorTags","TAG(S) IS REQUIRED");
			validation = false;
		}
		if (tagger.length > 3) {
			redirectAttributes.addFlashAttribute("errorTags2","THERE CAN ONLY BE THREE TAGS TOTAL");
			validation = false;
		}
		if (validation == true) {
			Question newQuestion = new Question(); // new question
			newQuestion.setQuestion(question); // set question
			List<Tag> tagg = new ArrayList<Tag>(); // empty list
			for (String tag:tagger) {
				Tag check = tagService.checkIfTagExists(tag);
				if (check==null) {
					Tag eachTag = new Tag(tag); //construct tags
					tagService.createTag(eachTag);
					tagg.add(eachTag); // add to empty list					
				} else {
					tagg.add(check);
				}
			}
			newQuestion.setTags(tagg); //set taglist to newQ taglist
			questionService.createItem(newQuestion);// save
			return "redirect:/questions";
		} else {
			return "redirect:/questions/new";			
		}
	}
}
