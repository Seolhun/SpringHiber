package com.shun.blog.model.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="TB_USER_PROFILE")
@Data
public class UserProfile implements Serializable{
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_PROFILE_ID", length=10, nullable=false)
	private int id;	

	@Column(name="USER_PROFILE_TYPE", length=15, unique=true, nullable=false)
	private String type = UserProfileType.GUEST.getUserProfileType();
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		result = prime * result + ((type == null) ? 0 : type.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (!(obj instanceof UserProfile))
//			return false;
//		UserProfile other = (UserProfile) obj;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		if (type == null) {
//			if (other.type != null)
//				return false;
//		} else if (!type.equals(other.type))
//			return false;
//		return true;
//	}
//
//	@Override
//	public String toString() {
//		return "UserProfile [id=" + id + ", type=" + type + "]";
//	}
}
