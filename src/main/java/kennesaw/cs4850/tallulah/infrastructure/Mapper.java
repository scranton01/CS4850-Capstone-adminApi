package kennesaw.cs4850.tallulah.infrastructure;

import kennesaw.cs4850.tallulah.domain.Sample;
import org.apache.ibatis.annotations.Select;

@org.apache.ibatis.annotations.Mapper
public interface Mapper {
    @Select("SELECT * FROM SAMPLE WHERE ID = 999")
    Sample getSample();
}
