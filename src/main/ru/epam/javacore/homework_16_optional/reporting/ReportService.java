package main.ru.epam.javacore.homework_16_optional.reporting;

import main.ru.epam.javacore.homework_16_optional.common.business.exception.checked.ReportException;

public interface ReportService {
    void exportData() throws ReportException;
}
