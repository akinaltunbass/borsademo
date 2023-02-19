package com.project.borsa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.borsa.dto.ShareCreateRequest;
import com.project.borsa.dto.ShareUpdateRequest;
import com.project.borsa.model.Share;
import com.project.borsa.repository.ShareRepository;

@Service
public class ShareService {
	
	private ShareRepository shareRepository;
	
	

	public ShareService(ShareRepository shareRepository) {
		this.shareRepository = shareRepository;
	}

	public List<Share> getAllShares() {
		return shareRepository.findAll();
	}

	public Share createOneShare(ShareCreateRequest newShareRequest) {
		Share toSaveShare = new Share();
		toSaveShare.setCode(newShareRequest.getCode());
		toSaveShare.setName(newShareRequest.getName());
		toSaveShare.setPrice(newShareRequest.getPrice());
		return shareRepository.save(toSaveShare);
	}

	public Share getShareById(Long shareId) {
		return shareRepository.findById(shareId).orElse(null);
	}

	public Share updateOneShareById(Long shareId, ShareUpdateRequest updateShareRequest) {
		Optional<Share> share = shareRepository.findById(shareId);
		if(share.isPresent()) {
			Share foundShare = share.get();
			foundShare.setCode(updateShareRequest.getCode());
			foundShare.setName(updateShareRequest.getName());
			foundShare.setPrice(updateShareRequest.getPrice());
			shareRepository.save(foundShare);
			return foundShare;
			
		}else
			
		return null;
	}

	public void deleteOneShareById(Long shareId) {
		shareRepository.deleteById(shareId);
		
	}

	public List<Share> getAllMyShares(Long userId) {
		return shareRepository.findByUserId(userId);
	
	}

}
