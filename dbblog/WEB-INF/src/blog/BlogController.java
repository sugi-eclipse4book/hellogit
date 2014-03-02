package blog;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
* BLOG�𑀍삷��r�W�l�X���W�b�N
*/

public class BlogController{
	/**
	 * �V���O���̃C���X�^���X
	 */
	public static BlogController controller = new
	BlogController();

	/**
	 * ���̃N���X�̃C���X�^���X���擾���܂�
	 * @return BlogController�̃C���X�^���X
	 */
	public static BlogController getInstance(){
		return controller;
	}

	private BlogController() {
	}

	/**
	 * �g�s�b�N���|�X�g�i�o�^�j���܂�
	 * @param topic
	 */
	public void postTopic(Topic topic){
		String sql = "INSERT INTO TOPIC(TITLE, CONTENT)"
				+ " VALUES(" + "'" + topic.getTitle() + "'"
				+ ",'" + topic.getContent() + "'" + ")";

		Connection con = null;
		Statement smt = null;
		try {
			con = ConnectionManager.getConnection();
			smt = con.createStatement();
			smt.executeUpdate(sql);
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			if (smt != null){
				try{
					smt.close();
				}catch (Exception ignore){
				}
			}
			if (con != null){
				try{
					con.close();
				}catch (Exception ignore){
				}
			}
		}
	}
	/**
	 * �ŋ߂́i�S�āj�g�s�b�N�X���擾���܂��B
	 * @return �g�s�b�N�̃��X�g
	 */
	public List<Topic> getTopics(){
		String sql = "SELECT * FROM TOPIC";
		List<Topic> topics = new ArrayList<Topic>();

		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;
		try {
			con = ConnectionManager.getConnection();
			smt = con.createStatement();
			rs = smt.executeQuery(sql);
			while (rs.next()){
				Topic topic = new Topic();
				topic.setId(rs.getInt("ID"));
				topic.setPostDate(rs.getTimestamp("POST_DATE"));
				topic.setTitle(rs.getString("TITLE"));
				topic.setContent(rs.getString("CONTENT"));
				topics.add(topic);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			if (rs != null){
				try{
					rs.close();
				}catch (Exception ignore){
				}
			}
			if (con != null){
				try{
					con.close();
				}catch (Exception ignore){
				}
			}
		}
		return topics;
	}

	public static void main(String[] args){
		BlogController ctrl = BlogController.getInstance();
		List <Topic> topics = ctrl.getTopics();
		for (int i = 0; i < topics.size(); i++){
			System.out.println(topics.get(i));
		}
		System.out.println("END");
	}
}