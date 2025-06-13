package com.Mangesh.ExpenseTracker.services.Stats;

import com.Mangesh.ExpenseTracker.dto.GraphDTO;
import com.Mangesh.ExpenseTracker.dto.StatsDTO;

public interface StatsService {

    GraphDTO getChartData();

    StatsDTO getStats();
}
