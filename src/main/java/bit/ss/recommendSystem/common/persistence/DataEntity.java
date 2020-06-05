package bit.ss.recommendSystem.common.persistence;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 * 所有表格的对应实体类的基类
 * 提供了基础的通用属性
 */
@MappedSuperclass
public class DataEntity<T> {
    @Transient
    private Page<T> page; // 分页对象

    public DataEntity() {

    }

    public Page<T> getPage() {
        return page;
    }

    public void setPage(Page<T> page) {
        this.page = page;
    }




}
