package com.acmebank.quarkus.repo;

import com.acmebank.quarkus.model.AcmeBank;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AcmeBankRepo{

    @Select("select * from AcmeBank")
    List<AcmeBank> findAll();

    @Select("SELECT * FROM AcmeBank WHERE id = #{id}")
    AcmeBank findById(long id);

    @Delete("DELETE FROM AcmeBank WHERE id = #{id}")
    int deleteById(long id);

    @Insert("INSERT INTO AcmeBank(id, name, accountNo) VALUES (#{id}, #{name}, #{accountNo})")
    int insert(AcmeBank acmeBank);

    @Update("Update AcmeBank set name=#{name}, accountNo=#{accountNo} where id=#{id}")
    int update(AcmeBank acmeBank);

}
