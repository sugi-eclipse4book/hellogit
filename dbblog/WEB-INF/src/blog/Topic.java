package blog;

import java.util.Date;

/**
* �g�s�b�N�̃r�[��
*/

public class Topic{
	/** �A�� */
	private int id;
	/** �^�C�g�� */
	private String title;
	/** ���e */
	private String content;
	/** ���e�� */
	private Date postDate;

	public String toString(){
		return super.toString()
			+ ",id=" + id
			+ ",title=" + title
			+ ",content=" + content
			+ ",postDate=" + postDate
			;
	}

	//
	//�P���ȃZ�b�^�A�Q�b�^
	//
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getContent(){
		return content;
	}
	public void setContent(String content){
		this.content = content;
	}
	public Date getPostDate(){
		return postDate;
	}
	public void setPostDate(Date postDate){
		this.postDate = postDate;
	}
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title = title;
	}
}