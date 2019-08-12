package com.mytoshika.auth.service;




import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mytoshika.auth.model.CourseModel;
import com.mytoshika.auth.model.CourseSectionContentModel;
import com.mytoshika.auth.model.CourseSectionModel;
import com.mytoshika.auth.model.entity.Course;
import com.mytoshika.auth.model.entity.CourseSection;
import com.mytoshika.auth.model.entity.CourseSectionContent;
import com.mytoshika.auth.model.entity.InstructorInfo;
import com.mytoshika.auth.repository.CourseRepository;
import com.mytoshika.auth.repository.CourseSectionContentRepository;
import com.mytoshika.auth.repository.CourseSectionRepository;
import com.mytoshika.auth.repository.InstructorRepository;

@Service
public class CourseRestServiceImp implements CourseRestService{

	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	InstructorRepository instructorRepository;

	@Autowired
	CourseSectionContentRepository courseSectionContentRepository;

	@Autowired
	CourseSectionRepository courseSectionRepository;

	
	public boolean createCourse(CourseModel courseModel,String email) {

                            
		Course courseentity = new Course();

		courseentity.setCourseType(courseModel.getCourseType());
		courseentity.setCourseStatus(courseModel.getCourseStatus());
		courseentity.setCourseTitle(courseModel.getCourseTitle());
		courseentity.setCourseDescription(courseModel.getCourseDescription());
		InstructorInfo instructorInfo = instructorRepository.findByEmail(email);
				
		courseentity.setInstructorInfo(instructorInfo);
		courseRepository.save(courseentity);

		return true;		


	}


	public Course getCourseInfo(Long id) {

		return courseRepository.findById(id).get();


	}


	public boolean deleteCourse(Long id) {
		Optional<Course> course = courseRepository.findById(id);
		if(course.isPresent())
		{
			courseRepository.delete(course.get());
		}
		else
		{ 
          return false;
		}
		return true;
	}


	public boolean updateCourseInfo(CourseModel courseModel) {

		Optional<Course> course = courseRepository.findById(courseModel.getCourseId());
		if(course.isPresent())
		{
			Course courseEntity = course.get();
			courseEntity.setCourseType(courseModel.getCourseType());
			courseEntity.setCourseStatus(courseModel.getCourseStatus());
			courseEntity.setCourseTitle(courseModel.getCourseTitle());
			courseEntity.setCourseDescription(courseModel.getCourseDescription());
			courseEntity = courseRepository.save(courseEntity);

			return true;
		}


		return false;
	}

	/*public boolean uploadFile(List<MultipartFile> uploadfileList ,long id)
	{

		try {
		      // Get the filename and build the local file path
		    	List<File> fileUploadList = new ArrayList<>();
		    	for(MultipartFile uploadfile : uploadfileList) {
		      String filename = uploadfile.getOriginalFilename();
		      filename = filename.replaceAll(" ", "");
		      String directory = env.getProperty("netgloo.paths.uploadedFiles");
		      String filepath = Paths.get(directory, filename).toString();
		      String path = "/CourseFile/";

		      // Save the file locally
		      BufferedOutputStream stream =
		          new BufferedOutputStream(new FileOutputStream(filepath));
		      stream.write(uploadfile.getBytes());
		      stream.close();

		      File file = new File();
				file.setFileName(filename);
				file.setFilePath(filePath);
				CourseSectionContent courseSectionContent= coursesectioncontentrepository.findbyId(id);
				file.setFilePath(courseSectionContent);

		    	}
		    }
		    catch (Exception e) {
		      System.out.println(e.getMessage());

		    }

		return true;

	}*/

	public boolean insertCourseSectionContent(CourseSectionContentModel courseSectionContentModel)
	{  
		CourseSectionContent courseSectionContent = new CourseSectionContent();

		courseSectionContent.setContentType(courseSectionContentModel.getContentType());
		courseSectionContent.setDuration(courseSectionContentModel.getContentDuration());
		//courseSectionContent.setUrl_path(File);
		courseSectionContent.setTitle(courseSectionContentModel.getContentTitle());
		courseSectionContent.setDescription(courseSectionContentModel.getContentDescription());
		courseSectionContentRepository.save(courseSectionContent);

		return true;

	}

	public CourseSectionContent getCourseSectionContent(Long id)
	{
		return courseSectionContentRepository.findById(id).get();

	}

	public boolean deleteCourseSectionContent(Long id)
	{
		Optional<CourseSectionContent> courseSectionContent = courseSectionContentRepository.findById(id);
		if(courseSectionContent.isPresent())
		{
			courseSectionContentRepository.delete(courseSectionContent.get());
		}
		else
		{
			System.out.println("Id is not correct");
		}
		return true;

	}

	public boolean updateCourseSectionContent(CourseSectionContentModel courseSectionContentModel)
	{
		Optional<CourseSectionContent> courseSectionContent = courseSectionContentRepository.findById(courseSectionContentModel.getCountId());
		if(courseSectionContent.isPresent())
		{
			CourseSectionContent courseSectionContentEntity = courseSectionContent.get();
			courseSectionContentEntity.setContentType(courseSectionContentModel.getContentType());
			courseSectionContentEntity.setDuration(courseSectionContentModel.getContentDuration());
			//courseSectionContent.setUrl_path(File);
			courseSectionContentEntity.setTitle(courseSectionContentModel.getContentTitle());
			courseSectionContentEntity.setDescription(courseSectionContentModel.getContentDescription());
			courseSectionContentEntity = courseSectionContentRepository.save(courseSectionContentEntity);

			return true;
		}
		return false;
	}


	public boolean createCourseSection(CourseSectionModel courseSectionModel)
	{
		CourseSection courseSection = new CourseSection();

		courseSection.setTitle(courseSectionModel.getSectionTitle());
		courseSection.setDescription(courseSectionModel.getSectionDescription());
		courseSection.setSequence(courseSectionModel.getSectionSequence());


		return true;


	}


	public CourseSection getCourseSection(Long id) 
	{
		return courseSectionRepository.findById(id).get();

	}

	public boolean deleteCourseSection(Long id)
	{
		Optional<CourseSection> courseSection = courseSectionRepository.findById(id);
		if(courseSection.isPresent())
		{
			courseSectionRepository.delete(courseSection.get());
		}
		else
		{
			System.out.println("id is not correct");
		}
		return true;
	}

	public boolean  updateCourseSection(CourseSectionModel courseSectionModel)
	{
		Optional<CourseSection> courseSection = courseSectionRepository.findById(courseSectionModel.getSectionId());
		if(courseSection.isPresent())
		{
			CourseSection courseSectionEntity= courseSection.get();
			courseSectionEntity.setTitle(courseSectionModel.getSectionTitle());
			courseSectionEntity.setDescription(courseSectionModel.getSectionDescription());
			courseSectionEntity.setSequence(courseSectionModel.getSectionSequence());
			courseSectionEntity=courseSectionRepository.save(courseSectionEntity);

			return true;
		}

		return false;

	}

}
