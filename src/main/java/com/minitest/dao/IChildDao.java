package com.minitest.dao;

import com.minitest.model.child;

import java.net.UnknownServiceException;
import java.sql.SQLException;
import java.util.List;

public interface IChildDao  {

    public List<child>displayAllChildren();

    public void addNewChild(child child) throws SQLException;

    public child getChildByIdS(int idS);

    public boolean editChild (child child);

}
