package kennesawstate.cs4850.tallulah.infrastructure;

import kennesawstate.cs4850.tallulah.domain.Sample;

@org.apache.ibatis.annotations.Mapper
public interface Mapper {
//    @Select("SELECT ID, NAME FROM SAMPLE WHERE ID = 999")
    Sample getSample();
}
