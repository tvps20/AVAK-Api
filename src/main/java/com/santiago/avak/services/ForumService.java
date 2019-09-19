package com.santiago.avak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.avak.domain.Forum;
import com.santiago.avak.dtos.ForumDTO;
import com.santiago.avak.repositories.ForumRepository;

@Service
public class ForumService extends BaseService<Forum, ForumDTO> {
	
	@Autowired
	public ForumService(ForumRepository repository) {
		super(repository);
	}
	
	@Override
	public Class<Forum> getTClass() {
		return Forum.class;
	}

	@Override
	public Forum fromDTO(ForumDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateData(Forum newObj, Forum obj) {
		// TODO Auto-generated method stub
		
	}
}
