package main.ru.epam.javacore.homework_17_date_stream.reporting;

import main.ru.epam.javacore.homework_17_date_stream.common.business.exception.checked.ReportException;

public interface ReportService {
    void exportData() throws ReportException;
}
