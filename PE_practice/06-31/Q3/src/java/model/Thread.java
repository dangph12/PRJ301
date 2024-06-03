/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.DiscussDAO;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class Thread {

    public ArrayList<Thread> getAllThreadFromDatabase() {
        Comment comment = new Comment();
        ArrayList<Thread> threadList = new ArrayList<>();
        try {
            DiscussDAO discussDAO = new DiscussDAO();
            ResultSet rs = discussDAO.queryAllThread();
            while (rs.next()) {
                int tid = rs.getInt("tid");
                String tcontext = rs.getString("tcontext");
                ArrayList<Comment> comments = comment.getAllCommentEachThread(tid);
                
                Thread thread = new Thread(tid, tcontext, comments);
                
                threadList.add(thread);
            }
        } catch (Exception e) {
        }
        return threadList;
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

    private String tcontext;

    /**
     * Get the value of tcontext
     *
     * @return the value of tcontext
     */
    public String getTcontext() {
        return tcontext;
    }

    /**
     * Set the value of tcontext
     *
     * @param tcontext new value of tcontext
     */
    public void setTcontext(String tcontext) {
        this.tcontext = tcontext;
    }

    private ArrayList<Comment> comments = new ArrayList<>();

    /**
     * Get the value of comments
     *
     * @return the value of comments
     */
    public ArrayList<Comment> getComments() {
        return comments;
    }

    /**
     * Set the value of comments
     *
     * @param comments new value of comments
     */
    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public Thread(int tid, String tcontext, ArrayList<Comment> comments) {
        this.tid = tid;
        this.tcontext = tcontext;
        this.comments = comments;
    }

    public Thread() {
    }

}
