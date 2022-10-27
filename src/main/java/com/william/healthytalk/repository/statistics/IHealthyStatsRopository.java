package com.william.healthytalk.repository.statistics;

import com.william.healthytalk.entity.statistics.HealthStatsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface IHealthyStatsRopository extends CrudRepository<HealthStatsEntity, Integer> {
    ArrayList<HealthStatsEntity> findHealthStatsEntitiesByUserId(int userId);
}
