package com.mytoshika.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mytoshika.auth.model.Instructor;
import com.mytoshika.auth.model.entity.InstructorInfo;

import com.mytoshika.auth.repository.InstructorRepository;






@Service
public class InstructorInfoServiceImp implements InstructorInfoService {

	@Autowired
	InstructorRepository instructorRepository;


	public boolean registerInstructor(Instructor instructor) 
	{

		InstructorInfo instructorInfo= instructorRepository.findByEmail(instructor.getEmail());


		if(instructorInfo != null) {
		
			return false;
		}

		InstructorInfo instructorInfoEntity = new InstructorInfo();

		instructorInfoEntity.setName(instructor.getName());
		instructorInfoEntity.setEmail(instructor.getEmail());
		instructorInfoEntity.setAddress(instructor.getAddress());
		instructorInfoEntity.setGender(instructor.getGender());
		instructorInfoEntity.setSkills(instructor.getSkills());
		instructorRepository.save(instructorInfoEntity);

		return true;
	}

	public boolean deleteInstructor(String email)
	{
		InstructorInfo instructorInfo = instructorRepository.findByEmail(email);

		if(instructorInfo != null)
		{
		instructorRepository.delete(instructorInfo);
		return true;
		}
	return false;	

	}	

	public InstructorInfo getInstructorInfo(String email) {
		
		InstructorInfo instructorInfo= instructorRepository.findByEmail(email);
          if(instructorInfo!=null)
          {
				return instructorInfo;
          }
          return null;

	}

	public boolean  updateInstructorInfo(Instructor instructor)
	{

		InstructorInfo instructorInfo = instructorRepository.findByEmail(instructor.getEmail());

		if(instructorInfo != null)
		{
			instructorInfo.setName(instructor.getName());
			instructorInfo.setEmail(instructor.getEmail());
			instructorInfo.setAddress(instructor.getAddress());
			instructorInfo.setGender(instructor.getGender());
			instructorInfo.setSkills(instructor.getSkills());
			instructorInfo = instructorRepository.save(instructorInfo);

			if(null!=instructorInfo) 

				return true;

		}

		return false;

	}


}
