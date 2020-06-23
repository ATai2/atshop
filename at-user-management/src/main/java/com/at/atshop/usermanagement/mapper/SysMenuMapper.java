package com.at.atshop.usermanagement.mapper;

import com.at.atshop.usermanagement.entity.SysMenu;
import com.at.atshop.usermanagement.entity.SysMenuExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysMenuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu
     *
     * @mbggenerated
     */
    int countByExample(SysMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu
     *
     * @mbggenerated
     */
    int deleteByExample(SysMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu
     *
     * @mbggenerated
     */
    int insert(SysMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu
     *
     * @mbggenerated
     */
    int insertSelective(SysMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu
     *
     * @mbggenerated
     */
    List<SysMenu> selectByExample(SysMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu
     *
     * @mbggenerated
     */
    SysMenu selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysMenu record);
}