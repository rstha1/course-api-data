package com.couseapi.data.topic;  //Package name should be consistent

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	
	// call the dependency
	@Autowired 
	private TopicService topicService;  //= new TopicService();
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopic() {
			
		return topicService.getAllTopic();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopicById(id);
	}

	@RequestMapping("/topicsN/{name}") // GET Request
	public Topic getTopicName(@PathVariable String name) {
		return topicService.getTopicByName(name);
	}
	
//	@RequestMapping(method=RequestMethod.POST, value="/topics")
	@PostMapping("/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@PutMapping("/topics")
	public void updateTopic(@RequestBody Topic topic) {
		topicService.updateTopic(topic);
	}
	
	@PutMapping("/topicsN")
	public void updateTopicName(@RequestBody Topic topic) {
		topicService.updateTopicByName(topic);
	}
	
}
