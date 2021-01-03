package com.couseapi.data.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;



	public List<Topic> getAllTopic(){
		//return topics;
		
		List<Topic> topics = new ArrayList<>();
		Iterable<Topic> it = topicRepository.findAll();
		it.forEach(topics::add);
		return topics;

	}

	public Topic getTopicById(String id) {
		return topicRepository.findById(id).get();

	}

	// (Array) topics[i] == topics.get(i) (List);
	public Topic getTopicByName(String name) {
		
		List<Topic> topics = this.getAllTopic();

		for (int i = 0; i< topics.size(); i++) {
			if(topics.get(i).getName().equals(name)) {
				return topics.get(i);
			}	
		}

		return null;
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}


	public void updateTopic(Topic topic) {
		topicRepository.save(topic);

	}

	public void updateTopicByName(Topic topic) {
		

	}
}
