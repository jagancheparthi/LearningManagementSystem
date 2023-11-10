package com.te.lmsp.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Mentor {
	@Id
	@Column(name = "mentor_id")
	private String employeeId;

	@NotNull(message = "MentorName should not be NULL")
	@NotBlank(message = "MentorName should not be BLANK")
	@Size(max = 100)
	@Column(name = "mentor_name")
	private String mentorName;

	@NotNull(message = "Email  should not be NULL")
	@NotBlank(message = "Email should not be NULL")
	@Email(message = "Inalid Email")
	@NotEmpty(message = "Email should not be empty")
	@Column(name = "ment_email", unique = true)
	private String email;

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Skill> skills;

	
	@OneToOne(mappedBy = "mentor")
	private Batch batch;
}
