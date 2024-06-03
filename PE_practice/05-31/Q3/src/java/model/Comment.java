/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.DiscussDAO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Comment {

    private String displayName;

    /**
     * Get the value of displayName
     *
     * @return the value of displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Set the value of displayName
     *
     * @param displayName new value of displayName
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    private String ctext;

    /**
     * Get the value of ctext
     *
     * @return the value of ctext
     */
    public String getCtext() {
        return ctext;
    }

    /**
     * Set the value of ctext
     *
     * @param ctext new value of ctext
     */
    public void setCtext(String ctext) {
        this.ctext = ctext;
    }

    public Comment() {
    }

    public Comment(String displayName, String ctext) {
        this.displayName = displayName;
        this.ctext = ctext;
    }

    public ArrayList<Comment> getAllCommentEachThread(int tid) {
        ArrayList<Comment> commentList = new ArrayList<>();
        try {
            DiscussDAO discussDAO = new DiscussDAO();
            ResultSet rs = discussDAO.queryAllCommentEachThread(tid);
            while (rs.next()) {
                Comment comment = new Comment(rs.getString("displayname"), rs.getString("ctext"));
                commentList.add(comment);
            }
        } catch (Exception e) {
        }
        return commentList;
    }

    private int cid;

    /**
     * Get the value of cid
     *
     * @return the value of cid
     */
    public int getCid() {
        return cid;
    }

    /**
     * Set the value of cid
     *
     * @param cid new value of cid
     */
    public void setCid(int cid) {
        this.cid = cid;
    }

    private String userid;

    /**
     * Get the value of userid
     *
     * @return the value of userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * Set the value of userid
     *
     * @param userid new value of userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    private int tid;

    /**
     * Get the value of tid
     *
     * @return the value of tid
     */
    public int getTid() {
        return tid;
    }

    /**
     * Set the value of tid
     *
     * @param tid new value of tid
     */
    public void setTid(int tid) {
        this.tid = tid;
    }

    public Comment(int cid, String ctext, String userid, int tid) {
        this.cid = cid;
        this.ctext = ctext;
        this.userid = userid;
        this.tid = tid;
    }
    
    

}
