package gr.quizbomb.repository;

import java.util.List;

import gr.quizbomb.model.Question;

public interface QuestionDAO extends GenericRepository<Question>{

	public List<Question> findByApproved(boolean b);
	
    public List<Question> findBySClassIdAndCourseId(Long s, Long c);
	
	
	/** 
	@Query("SELECT q FROM Question q, SClass s,  Course c "
	 		+ "WHERE q.sClass.id = s.id "
            + "AND q.course.id = c.id "
			+ "AND q.sClass.id = :s_id and q.course.id = :c_id")
	  public List<Question> loadQuestions(@Param("s_id") Long sClass, @Param("c_id") Long course);
	  
	
    @Query("SELECT * FROM Question  WHERE approved = :b")
    public List<QuestionEntity> findUnapproved(@Param("b") Boolean tasos); **/

}
