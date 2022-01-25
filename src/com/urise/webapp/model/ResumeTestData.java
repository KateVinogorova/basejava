package com.urise.webapp.model;

import java.util.Map;

import static com.urise.webapp.model.Resume.*;
import static com.urise.webapp.model.SectionType.*;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("Григорий Кислин");
        resume.addContact("Тел.: ", "+7(921) 855-0482", "");
        resume.addContact("Skype: ", "grigory.kislin", "");
        resume.addContact("Почта: ", "gkislin@yandex.ru", "");
        resume.addContact("", "Профиль LinkedIn", "");
        resume.addContact("", "Профиль GitHub", "");
        resume.addContact("", "Профиль Stackoverflow", "");
        resume.addContact("", "Домашняя страница", "");

        TextSection objective = new TextSection();
        objective.setDescription("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
        resume.sections.put(OBJECTIVE, objective);

        TextSection personal = new TextSection();
        personal.setDescription("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");
        resume.sections.put(PERSONAL, personal);

        ListSection achievement = new ListSection();
        achievement.addListItem("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", " +
                "\"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). " +
                "Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.");
        achievement.addListItem("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. " +
                "Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
        achievement.addListItem("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. " +
                "Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: " +
                "Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, " +
                "интеграция CIFS/SMB java сервера.");
        achievement.addListItem("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, " +
                "Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.");
        achievement.addListItem("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов " +
                "(SOA-base архитектура, JAX-WS, JMS, AS Glassfish). " +
                "Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. " +
                "Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).");
        achievement.addListItem("Реализация протоколов по приему платежей всех основных платежных системы России " +
                "(Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");
        resume.sections.put(ACHIEVEMENT, achievement);

        ListSection qualification = new ListSection();
        qualification.addListItem("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        qualification.addListItem("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        qualification.addListItem("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle");
        qualification.addListItem("MySQL, SQLite, MS SQL, HSQLDB");
        qualification.addListItem("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy");
        qualification.addListItem("XML/XSD/XSLT, SQL, C/C++, Unix shell scripts");
        qualification.addListItem("Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, " +
                "Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, " +
                "GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, " +
                "Selenium (htmlelements).");
        qualification.addListItem("Python: Django.");
        qualification.addListItem("JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js");
        qualification.addListItem("Scala: SBT, Play2, Specs2, Anorm, Spray, Akka");
        qualification.addListItem("Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, " +
                "SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, " +
                "OAuth1, OAuth2, JWT.");
        qualification.addListItem("Инструменты: Maven + plugin development, Gradle, настройка Ngnix,");
        qualification.addListItem("администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, " +
                "Nagios, iReport, OpenCmis, Bonita, pgBouncer.");
        qualification.addListItem("Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, " +
                "архитектурных шаблонов, UML, функционального программирования");
        qualification.addListItem("Родной русский, английский \"upper intermediate\"");
        resume.sections.put(QUALIFICATIONS, qualification);

        MapSection experience = new MapSection();
        experience.addItem("10/2013 - Сейчас", "Java Online Projects", "Автор проекта.",
                "Создание, организация и проведение Java онлайн проектов и стажировок.");
        experience.addItem("10/2014 - 01/2016", "Wrike", "Старший разработчик (backend)",
                "Проектирование и разработка онлайн платформы управления проектами Wrike " +
                        "(Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). " +
                        "Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.");
        experience.addItem("04/2012 - 10/2014", "RIT Center", "Java архитектор",
                "Организация процесса разработки системы ERP для разных окружений: релизная политика, " +
                        "версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), " +
                        "конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. " +
                        "Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения " +
                        "(почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера " +
                        "документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, " +
                        "Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting " +
                        "via ssh tunnels, PL/Python");
        experience.addItem("12/2010 - 04/2012", "Luxoft (Deutsche Bank)", "Ведущий программист",
                "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, " +
                        "GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. " +
                        "Реализация RIA-приложения для администрирования, мониторинга и анализа результатов " +
                        "в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, " +
                        "Commet, HTML5.");
        experience.addItem("06/2008 - 12/2010", "Yota", "Ведущий специалист",
                "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" " +
                        "(GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). " +
                        "Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента " +
                        "(Python/ Jython, Django, ExtJS)");
        experience.addItem("03/2007 - 06/2008", "Enkata", "Разработчик ПО",
                "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) " +
                        "частей кластерного J2EE приложения (OLAP, Data mining).");
        experience.addItem("01/2005 - 02/2007", "Siemens AG", "Разработчик ПО",
                "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО " +
                        "на мобильной IN платформе Siemens @vantage (Java, Unix).");
        experience.addItem("09/1997 - 01/2005", "Alcatel", "Инженер по аппаратному и программному тестированию",
                "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).");
        resume.sections.put(EXPERIENCE, experience);

        MapSection education = new MapSection();
        education.addItem("03/2013 - 05/2013", "Coursera", "\"Functional Programming Principles in Scala\" by Martin Odersky", null);
        education.addItem("03/2011 - 04/2011", "Luxoft", "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"",
                null);
        education.addItem("01/2005 - 04/2005", "Siemens AG", "3 месяца обучения мобильным IN сетям (Берлин)", null);
        education.addItem("09/1997 - 03/1998", "Alcatel", "6 месяцев обучения цифровым телефонным сетям (Москва)", null);
        education.addItem("09/1993 - 07/1996", "Санкт-Петербургский национальный исследовательский университет " +
                "информационных технологий, механики и оптики", "Аспирантура (программист С, С++)", null);
        education.addItem("09/1987 - 07/1993", "Санкт-Петербургский национальный исследовательский университет " +
                "информационных технологий, механики и оптики", "Инженер (программист Fortran, C)", null);
        education.addItem("09/1984 - 06/1987", "Заочная физико-техническая школа при МФТИ", "Закончил с отличием", null);
        resume.sections.put(EDUCATION, education);

        System.out.println(resume.getFullName());
        System.out.println("");
        resume.printContacts();
        System.out.println("");
        for (Map.Entry<SectionType, Section> s : resume.sections.entrySet()) {
            System.out.println("");
            System.out.println(s.getKey());
            System.out.println("");
            s.getValue().printSection();
        }
    }
}
