package gr.quizbomb.repository;

import java.util.List;

import gr.quizbomb.model.Question;

public interface QuestionDAO extends GenericRepository<Question>{

	public List<Question> findByApproved(boolean b);
	
	/** @Query("SELECT * FROM Question  WHERE approved = :b")
    public List<QuestionEntity> findUnapproved(@Param("b") Boolean tasos); **/

}
