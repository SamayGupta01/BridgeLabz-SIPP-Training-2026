CREATE DATABASE covid_analysis;
USE covid_analysis;

CREATE TABLE covid_19_india (
    Sno INT,
    Date DATE,
    Time VARCHAR(20),
    State_UnionTerritory VARCHAR(100),
    ConfirmedIndianNational VARCHAR(20),
    ConfirmedForeignNational VARCHAR(20),
    Cured INT,
    Deaths INT,
    Confirmed INT
);

CREATE TABLE StatewiseTestingDetails (
    Date DATE,
    State VARCHAR(100),
    TotalSamples BIGINT,
    Negative BIGINT,
    Positive BIGINT
);

CREATE TABLE covid_vaccine_statewise (
    State VARCHAR(100),
    Updated_On DATE,
    Total_Doses_Administered BIGINT,
    First_Dose_Administered BIGINT,
    Second_Dose_Administered BIGINT
);

SELECT COUNT(*) FROM covid_19_india;
SELECT COUNT(*) FROM StatewiseTestingDetails;
SELECT COUNT(*) FROM covid_vaccine_statewise;


-- Use Case 1: Find Highest Confirmed Cases using INNER JOIN 
SELECT
    c.State_UnionTerritory,
    c.Confirmed,
    t.TotalSamples
FROM covid_19_india c
INNER JOIN StatewiseTestingDetails t
ON c.State_UnionTerritory = t.State
AND c.Date = t.Date
WHERE c.Date = '2021-05-01'
ORDER BY c.Confirmed DESC
LIMIT 1;

-- Use Case 2: Join COVID Deaths and Vaccination Data
SELECT
    c.State_UnionTerritory,
    c.Deaths,
    v.Total_Doses_Administered
FROM covid_19_india c
LEFT JOIN covid_vaccine_statewise v
ON c.State_UnionTerritory = v.State;

-- Use Case 3: Analyze Deaths by State
SELECT
    c.State_UnionTerritory,
    SUM(c.Deaths) AS Total_Deaths
FROM covid_19_india c
INNER JOIN StatewiseTestingDetails t
ON c.State_UnionTerritory = t.State
GROUP BY c.State_UnionTerritory
ORDER BY Total_Deaths DESC;

-- Use Case 4: Calculate Average New Deaths Per Day
SELECT
    Date,
    AVG(Deaths) AS Avg_Daily_Deaths
FROM covid_19_india
GROUP BY Date
ORDER BY Date;

-- Use Case 5: Find States with Highest Infection Rates
SELECT
    c.State_UnionTerritory,
    ROUND(
        (MAX(c.Confirmed) * 100.0) /
        MAX(t.TotalSamples),
        2
    ) AS Infection_Rate
FROM covid_19_india c
INNER JOIN StatewiseTestingDetails t
ON c.State_UnionTerritory = t.State
AND c.Date = t.Date
GROUP BY c.State_UnionTerritory
ORDER BY Infection_Rate DESC;

