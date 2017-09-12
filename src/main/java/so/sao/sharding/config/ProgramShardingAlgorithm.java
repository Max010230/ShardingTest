package so.sao.sharding.config;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.SingleKeyTableShardingAlgorithm;
import com.google.common.collect.Range;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * Create by wuxingxing on 2017/8/21 16:00
 */
@Component
public final class ProgramShardingAlgorithm implements SingleKeyTableShardingAlgorithm<Integer> {
    /**
     * equals比较条件
     *
     * @param availableTargetNames
     * @param shardingValue
     * @return
     */
    @Override
    public String doEqualSharding(final Collection<String> availableTargetNames, final ShardingValue<Integer> shardingValue) {
        for (String each : availableTargetNames) {
            if (each.endsWith(shardingValue.getValue() % availableTargetNames.size() + "")) {
                return each;
            }
        }
        throw new UnsupportedOperationException();
    }

    /**
     * in比较条件
     *
     * @param availableTargetNames
     * @param shardingValue
     * @return
     */
    @Override
    public Collection<String> doInSharding(final Collection<String> availableTargetNames, final ShardingValue<Integer> shardingValue) {
        Collection<String> result = new LinkedHashSet<String>(availableTargetNames.size());
        Collection<Integer> values = shardingValue.getValues();
        for (Integer value : values) {
            for (String tableNames : availableTargetNames) {
                if (tableNames.endsWith(value % availableTargetNames.size() + "")) {
                    result.add(tableNames);
                }
            }
        }
        return result;
    }

    /**
     * between比较条件
     *
     * @param availableTargetNames
     * @param shardingValue
     * @return
     */
    @Override
    public Collection<String> doBetweenSharding(final Collection<String> availableTargetNames, final ShardingValue<Integer> shardingValue) {
        Collection<String> result = new LinkedHashSet<String>(availableTargetNames.size());
        Range<Integer> range = shardingValue.getValueRange();
        for (Integer i = range.lowerEndpoint(); i <= range.upperEndpoint(); i++) {
            for (String each : availableTargetNames) {
                if (each.endsWith(i % 14 + "")) {
                    result.add(each);
                }
            }
        }
        return result;
    }
}
