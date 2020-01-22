package main.ru.epam.javacore.homework_15_threads.reporting;

import main.ru.epam.javacore.homework_15_threads.common.business.exception.checked.ReportException;

public interface ReportService {
    void exportData() throws ReportException;
}
