package com.multi.fourtunes.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.multi.fourtunes.model.dto.CommunityDto;

@Mapper
public interface CommunityMapper {

	@Results({ @Result(property = "boardNo", column = "BOARD_NO"),
			@Result(property = "boardTitle", column = "BOARD_TITLE"),
			@Result(property = "boardContent", column = "BOARD_CONTENT"),
			@Result(property = "userNo", column = "USER_NO"),
			@Result(property = "boardReportCnt", column = "BOARD_REPORT_CNT"),
			@Result(property = "boardWriteDate", column = "BOARD_WRITE_DATE"),
			@Result(property = "boardViewCnt", column = "BOARD_VIEW_CNT") })
	@Select(" SELECT * FROM COMMUNITY_BOARD ")
	List<CommunityDto> getAll();

	@Results({ @Result(property = "boardNo", column = "BOARD_NO"),
			@Result(property = "boardTitle", column = "BOARD_TITLE"),
			@Result(property = "boardContent", column = "BOARD_CONTENT"),
			@Result(property = "userNo", column = "USER_NO"),
			@Result(property = "boardReportCnt", column = "BOARD_REPORT_CNT"),
			@Result(property = "boardWriteDate", column = "BOARD_WRITE_DATE"),
			@Result(property = "boardViewCnt", column = "BOARD_VIEW_CNT") })
	@Select(" SELECT * FROM COMMUNITY_BOARD WHERE BOARD_NO = #{boardNo} ")
	CommunityDto get(int boardNo);

	@Results({ @Result(property = "boardNo", column = "BOARD_NO"),
			@Result(property = "boardTitle", column = "BOARD_TITLE"),
			@Result(property = "boardContent", column = "BOARD_CONTENT"),
			@Result(property = "userNo", column = "USER_NO"),
			@Result(property = "boardReportCnt", column = "BOARD_REPORT_CNT"),
			@Result(property = "boardWriteDate", column = "BOARD_WRITE_DATE"),
			@Result(property = "boardViewCnt", column = "BOARD_VIEW_CNT") })
	@Insert("INSERT INTO COMMUNITY_BOARD (BOARD_TITLE, BOARD_CONTENT, USER_NO, BOARD_WRITE_DATE) "
			+ "VALUES (#{boardTitle}, #{boardContent}, #{userNo}, #{boardWriteDate})")
	int insert(CommunityDto community);

	int update(CommunityDto community);

	int delete(int boardNo);
}
