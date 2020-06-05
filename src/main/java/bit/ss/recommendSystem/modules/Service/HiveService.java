package bit.ss.recommendSystem.modules.Service;

import bit.ss.recommendSystem.common.utils.HiveUtils;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class HiveService {

    /**
     * 增加用户评分接口
     * @param userId 用户id
     * @param movieId 电影id
     * @param rating 评分
     * @param timestamp 用户评分时间戳
     * @return 1成功 -1失败
     * @author wh
     */
    public int addUserRating(int userId,int movieId,double rating,int timestamp) throws SQLException {
        StringBuffer stringBuffer = new StringBuffer("");
        stringBuffer.append("insert into ratings (userId,movieId,rating,timestamp)values(");
        stringBuffer.append(userId+',');
        stringBuffer.append(movieId+',');
        stringBuffer.append(rating+',');
        stringBuffer.append(timestamp+ ");");
        return HiveUtils.doSql(stringBuffer.toString());
    }
}
