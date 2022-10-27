package com.william.healthytalk.service.stastics;

import com.william.healthytalk.entity.statistics.HealthStatsEntity;

import java.util.ArrayList;

public interface IHealthStatsService {
    Iterable<HealthStatsEntity> findAll();
    HealthStatsEntity save(HealthStatsEntity healthStatsEntity);
    ArrayList<HealthStatsEntity> findHealthStatsEntitiesByUserId(int userId);
}
