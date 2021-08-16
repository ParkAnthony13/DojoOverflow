package parkanthony.doo.services;

import org.springframework.stereotype.Service;

import parkanthony.doo.models.Answer;
import parkanthony.doo.repositories.AnswerRepository;

@Service
public class AnswerService {
	private final AnswerRepository answerRepository;
	
	public AnswerService(AnswerRepository answerRepository) {
		this.answerRepository = answerRepository;
	}
	public Answer createItem(Answer answer) {
		return answerRepository.save(answer);
	}
}
