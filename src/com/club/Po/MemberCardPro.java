package com.club.Po;

import java.util.List;

/**
 * Created by Administrator on 2019-04-22.
 */
public class MemberCardPro extends Member {
    private Card card;
    private List<Project> project;

    public MemberCardPro() {
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<Project> getProject() {
        return project;
    }

    public void setProject(List<Project> project) {
        this.project = project;
    }


    @Override
    public String toString() {
        return"Member{" +
                "memId=" + super.getMemId() +
                ", memName='" + super.getMemName() + '\'' +
                ", memSex='" + super.getMemSex() + '\'' +
                ", memAge=" + super.getMemAge() +
                ", memPhone='" + super.getMemPhone() + '\'' +
                ",card='" + card + '\'' +
                ", project='" + project + '\'' +
        '}';
    }
}
