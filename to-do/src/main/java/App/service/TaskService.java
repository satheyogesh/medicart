package App.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import App.taskdao.TaskRepository;
import App.userinfo.data;

@Service
@Transactional
public class TaskService {
	
	private final TaskRepository taskRepository;
	
	public TaskService(TaskRepository taskRepository)
	{
		this.taskRepository=taskRepository;
	}

	public List<data> findAll(){
		List<data> tasks = new ArrayList<data>();
		for(data d: taskRepository.findAll())
		{
			tasks.add(d);
		}
		return tasks;
	}
	
	public data findTask(int id)
	{
		return taskRepository.findOne(id);
	}
	
	public void save(data d)
	{
		taskRepository.save(d);
	}
	
	public void delete(int id)
	{
		taskRepository.delete(id);
	}
}
