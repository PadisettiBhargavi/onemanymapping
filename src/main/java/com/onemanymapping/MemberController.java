package com.onemanymapping;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class MemberController {
	@Autowired
	private MemberRepo memberRepo;
	@PostMapping("/api/member")
	public ResponseEntity<Member> saveMember(@RequestBody Member member){
		Member savedMember=memberRepo.save(member);
		return new ResponseEntity<Member>(savedMember,HttpStatus.CREATED);
		
	}
	@GetMapping("/api/member")
	public ResponseEntity<List<Member>> getAllMembers(){
		List<Member> members=memberRepo.findAll();
		return new ResponseEntity<List<Member>>(members,HttpStatus.OK);
	}
	
	@GetMapping("/api/member/id")
	public ResponseEntity<Member> getMemberById(@PathVariable int id ){
		Optional<Member> member=memberRepo.findById(id);
		if(member.isPresent()) {
			return new ResponseEntity<Member>(member.get(),HttpStatus.OK);
		}else {
		return new ResponseEntity<Member>(HttpStatus.NOT_FOUND);
	}
	}
		@PutMapping("/api/member/id")
		public ResponseEntity<Member> updatedMember(@PathVariable int id,@RequestBody Member updatedMember){
			Optional<Member> existingMember=memberRepo.findById(id);
			if(existingMember.isPresent()) {
				Member Member=existingMember.get();
				Member.setName(updatedMember.getName());
				Member.setGender(updatedMember.getGender());
				Member savedMember=memberRepo.save(Member);
			
				return new ResponseEntity<Member>(savedMember,HttpStatus.OK);
			}else {
			return new ResponseEntity<Member>(HttpStatus.NOT_FOUND);
		}
		}
		
			@DeleteMapping("/api/member/id")
			public ResponseEntity<Void> deleteMember(@PathVariable int id){
				Optional<Member> Member=memberRepo.findById(id);
				if(Member.isPresent()){
					
				
				
					return new ResponseEntity<Void>(HttpStatus.OK);
				}else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
}
}

