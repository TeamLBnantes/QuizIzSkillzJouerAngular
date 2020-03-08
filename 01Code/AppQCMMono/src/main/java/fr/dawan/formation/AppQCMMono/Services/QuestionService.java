package fr.dawan.formation.AppQCMMono.Services;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import fr.dawan.formation.AppQCMMono.Models.Answer;
import fr.dawan.formation.AppQCMMono.Models.Designer;
import fr.dawan.formation.AppQCMMono.Models.MCQ;
import fr.dawan.formation.AppQCMMono.Models.Question;
import fr.dawan.formation.AppQCMMono.Models.User;
import fr.dawan.formation.AppQCMMono.Persistence.AnswerDAO;
import fr.dawan.formation.AppQCMMono.Persistence.Constantes;
import fr.dawan.formation.AppQCMMono.Persistence.QuestionDAO;
import fr.dawan.formation.AppQCMMono.Persistence.UserDAO;

public class QuestionService {

	
	
	public Question saveOrUpdate(Question q) {
		QuestionDAO questionDao = new QuestionDAO(Constantes.PERSISTENCE_UNIT_NAME);
		
		Question question=questionDao.saveOrUpdate(q);
		questionDao.close();
		return question;
	}
	

	
	
	
	public void saveOrUpdate(Collection<Question> questions) {
		QuestionDAO questionDao = new QuestionDAO(Constantes.PERSISTENCE_UNIT_NAME);

		questionDao.saveOrUpdate(questions);
		questionDao.close();

	}

	public Question findById(int id) {
		QuestionDAO questionDao = new QuestionDAO(Constantes.PERSISTENCE_UNIT_NAME);

		return questionDao.findById(Question.class, id);
		
	}

	public Set<Question> findAll(Question d) {
		QuestionDAO questionDao = new QuestionDAO(Constantes.PERSISTENCE_UNIT_NAME);


	return questionDao.findAll(Question.class);
}



	public List<Question> searchByDesigner(Designer designer) {
		QuestionDAO questionDao = new QuestionDAO(Constantes.PERSISTENCE_UNIT_NAME);
		List<Question> questions=questionDao.searchByDesigner(designer);	
		questionDao.close();
		return questions;
	}

	public void deleteById(int id) {
		QuestionDAO questionDao = new QuestionDAO(Constantes.PERSISTENCE_UNIT_NAME);
		AnswerDAO answerDAO=new AnswerDAO(Constantes.PERSISTENCE_UNIT_NAME);
		Question question=questionDao.findById(Question.class, id);
		for (Answer answer : question.getAnswers()) {
			answerDAO.deleteById(Answer.class, answer.getId());
		}
		questionDao.deleteById(Question.class, id);
		
		
		
		
	}





	public List<Question> searchByMcq(MCQ mcq) {
		
		QuestionDAO questionDao = new QuestionDAO(Constantes.PERSISTENCE_UNIT_NAME);
		List<Question> questions=questionDao.searchByMcq(mcq);
		questionDao.close();
		return questions;
	}


}
