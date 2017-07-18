package com.shun.blog.service.notice;

import com.shun.blog.model.notice.Notice;

import java.util.List;

public interface NoticeService {

	void insertNotice(Notice notice) throws Exception;

	Notice selectNoticeById(Long noticeId) throws Exception;

	void updateNotice(Notice notice) throws Exception;

	void deleteNotice(Notice notice) throws Exception;

	List<Notice> findAllByAdmin(Notice notice) throws Exception;
}