package main.ru.epam.javacore.homework_13_sax.reporting;

import main.ru.epam.javacore.homework_13_sax.common.business.exception.checked.ReportException;

public interface ReportService {
    void exportData() throws ReportException;
}
