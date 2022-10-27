package com.william.healthytalk.service.stastics;

import com.william.healthytalk.entity.statistics.HealthStatsEntity;
import com.william.healthytalk.repository.statistics.IHealthyStatsRopository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class HealthStatsServiceImpl implements IHealthStatsService{
    @Autowired
    IHealthyStatsRopository healthyStatsRopository;
    @Override
    public Iterable<HealthStatsEntity> findAll() {
        return healthyStatsRopository.findAll();
    }

    @Override
    public HealthStatsEntity save(HealthStatsEntity healthStatsEntity) {
        return healthyStatsRopository.save(healthStatsEntity);
    }

    @Override
    public ArrayList<HealthStatsEntity> findHealthStatsEntitiesByUserId(int userId) {
        return healthyStatsRopository.findHealthStatsEntitiesByUserId(userId);
    }
}
