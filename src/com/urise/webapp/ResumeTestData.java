package com.urise.webapp;

import com.urise.webapp.model.*;

import java.time.YearMonth;

import static com.urise.webapp.model.ContactType.*;
import static com.urise.webapp.model.SectionType.*;

public class ResumeTestData {

    public static Resume createResume(String uuid, String fullName) {
        Resume resume = new Resume(uuid, fullName);

        resume.addContact(PHONE, "+7(921) 855-0482");
        resume.addContact(SKYPE, "grigory.kislin");
        resume.addContact(MAIL, "gkislin@yandex.ru");
        resume.addContact(LINKEDIN, "");
        resume.addContact(GITHUB, "");
        resume.addContact(STACKOVERFLOW, "");
        resume.addContact(WEBSITE, "");

        TextSection objective = new TextSection();
        objective.setDescription("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
        resume.addSection(OBJECTIVE, objective);

        TextSection personal = new TextSection();
        personal.setDescription("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");
        resume.addSection(PERSONAL, personal);

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
        resume.addSection(ACHIEVEMENT, achievement);

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
        resume.addSection(QUALIFICATIONS, qualification);

        OrganizationSection experienceStorage = new OrganizationSection();
        Organization javaOnlineProjects = new Organization("Java Online Projects");
        Position javaOnlineProjectsPosition = new Position.Builder().dateFrom(YearMonth.of(2013, 10))
                .dateTo(YearMonth.now()).title("Автор проекта.").description("Создание, организация и проведение " +
                        "Java онлайн проектов и стажировок.").build();
        experienceStorage.addOrganisation(javaOnlineProjects, javaOnlineProjectsPosition);

        Organization wrike = new Organization("Wrike");
        Position wrikePosition = new Position.Builder().dateFrom(YearMonth.of(2014, 10)).
                dateTo(YearMonth.of(2016, 1)).title("Старший разработчик (backend)").
                description("Проектирование и разработка онлайн платформы управления проектами Wrike " + "" +
                        "(Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). " +
                        "Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.").build();
        experienceStorage.addOrganisation(wrike, wrikePosition);

        Organization RITCenter = new Organization("RIT Center");
        Position RITCenterPosition = new Position.Builder().dateFrom(YearMonth.of(2012, 4)).
                dateTo(YearMonth.of(2014, 10)).title("Java архитектор").
                description("Организация процесса разработки системы ERP для разных окружений: релизная политика, " +
                        "версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), " +
                        "конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. " +
                        "Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения " +
                        "(почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера " +
                        "документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, " +
                        "Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting " +
                        "via ssh tunnels, PL/Python").build();
        experienceStorage.addOrganisation(RITCenter, RITCenterPosition);

        Organization luxoft = new Organization("Luxoft (Deutsche Bank)");
        Position luxoftPosition = new Position.Builder().dateFrom(YearMonth.of(2010, 12)).
                dateTo(YearMonth.of(2012, 4)).title("Ведущий программист").
                description("Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, " +
                        "GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. " +
                        "Реализация RIA-приложения для администрирования, мониторинга и анализа результатов " +
                        "в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, " +
                        "Commet, HTML5.").build();
        experienceStorage.addOrganisation(luxoft, luxoftPosition);

        Organization yota = new Organization("Yota");
        Position yotaPosition = new Position.Builder().dateFrom(YearMonth.of(2008, 6)).
                dateTo(YearMonth.of(2010, 12)).title("Ведущий специалист").
                description("Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" " +
                        "(GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). " +
                        "Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента " +
                        "(Python/ Jython, Django, ExtJS)").build();
        experienceStorage.addOrganisation(yota, yotaPosition);

        Organization enkata = new Organization("Enkata");
        Position enkataPosition = new Position.Builder().dateFrom(YearMonth.of(2008, 6)).
                dateTo(YearMonth.of(2010, 12)).title("Разработчик ПО").
                description("Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) " +
                        "частей кластерного J2EE приложения (OLAP, Data mining).").build();
        experienceStorage.addOrganisation(enkata, enkataPosition);

        Organization siemens = new Organization("Siemens AG");
        Position siemensPosition = new Position.Builder().dateFrom(YearMonth.of(2005, 1)).
                dateTo(YearMonth.of(2007, 2)).title("Разработчик ПО").
                description("Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО " +
                        "на мобильной IN платформе Siemens @vantage (Java, Unix).").build();
        experienceStorage.addOrganisation(siemens, siemensPosition);

        Organization alcatel = new Organization("Alcatel");
        Position alcatelPosition = new Position.Builder().dateFrom(YearMonth.of(1997, 9)).
                dateTo(YearMonth.of(2005, 1)).title("Инженер по аппаратному и программному тестированию").
                description("Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).").
                build();
        experienceStorage.addOrganisation(alcatel, alcatelPosition);
        resume.addSection(EXPERIENCE, experienceStorage);

        OrganizationSection educationStorage = new OrganizationSection();
        Organization coursera = new Organization("Coursera");
        Position courseraPosition = new Position.Builder().dateFrom(YearMonth.of(2013, 3)).
                dateTo(YearMonth.of(2013, 5)).title("\"Functional Programming Principles in Scala\" " +
                "by Martin Odersky").build();
        educationStorage.addOrganisation(coursera, courseraPosition);

        Organization luxoftEducation = new Organization("Luxoft");
        Position luxoftEducationPosition = new Position.Builder().dateFrom(YearMonth.of(2011, 3)).
                dateTo(YearMonth.of(2011, 4)).title("Курс \"Объектно-ориентированный анализ ИС. " +
                "Концептуальное моделирование на UML.\"").build();
        educationStorage.addOrganisation(luxoftEducation, luxoftEducationPosition);

        Organization siemensEducation = new Organization("Siemens AG");
        Position siemensEducationPosition = new Position.Builder().dateFrom(YearMonth.of(2005, 1)).
                dateTo(YearMonth.of(2005, 4)).title("3 месяца обучения мобильным IN сетям (Берлин)").build();
        educationStorage.addOrganisation(siemensEducation, siemensEducationPosition);

        Organization alcatelEducation = new Organization("Alcatel");
        Position alcatelEducationPosition = new Position.Builder().dateFrom(YearMonth.of(1997, 9)).
                dateTo(YearMonth.of(1998, 3)).title("6 месяцев обучения цифровым телефонным сетям (Москва)").
                build();
        educationStorage.addOrganisation(alcatelEducation, alcatelEducationPosition);

        Organization university = new Organization("Санкт-Петербургский национальный исследовательский " +
                "университет информационных технологий, механики и оптики");
        Position universityPosition1 = new Position.Builder().dateFrom(YearMonth.of(1993, 9)).
                dateTo(YearMonth.of(1996, 7)).title("Аспирантура (программист С, С++)").build();
        educationStorage.addOrganisation(university, universityPosition1);

        Position universityPosition2 = new Position.Builder().dateFrom(YearMonth.of(1987, 9)).
                dateTo(YearMonth.of(1993, 7)).title("Инженер (программист Fortran, C)").build();
        educationStorage.addOrganisation(university, universityPosition2);
        resume.addSection(EDUCATION, educationStorage);

        return resume;
    }
}
