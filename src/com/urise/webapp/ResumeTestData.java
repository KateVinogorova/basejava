package com.urise.webapp;

import com.urise.webapp.model.*;

import java.time.YearMonth;
import java.util.Map;

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

        ExperienceStorage experienceStorage = new ExperienceStorage();

        Experience javaOnlineProjects = new Experience();
        javaOnlineProjects.setPlace("Java Online Projects");
        javaOnlineProjects.setDates(YearMonth.of(2013, 10), YearMonth.now());
        javaOnlineProjects.setTitle("Автор проекта.");
        javaOnlineProjects.setDescription("Создание, организация и проведение Java онлайн проектов и стажировок.");
        experienceStorage.addExperience(javaOnlineProjects);

        Experience wrike = new Experience();
        wrike.setPlace("Wrike");
        wrike.setDates(YearMonth.of(2014, 10), YearMonth.of(2016, 1));
        wrike.setTitle("Старший разработчик (backend)");
        wrike.setDescription("Проектирование и разработка онлайн платформы управления проектами Wrike " + "" +
                "(Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). " +
                "Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.");
        experienceStorage.addExperience(wrike);

        Experience RITCenter = new Experience();
        RITCenter.setPlace("RIT Center");
        RITCenter.setDates(YearMonth.of(2012, 4), YearMonth.of(2014, 10));
        RITCenter.setTitle("Java архитектор");
        RITCenter.setDescription("Организация процесса разработки системы ERP для разных окружений: релизная политика, " +
                "версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), " +
                "конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. " +
                "Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения " +
                "(почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера " +
                "документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, " +
                "Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting " +
                "via ssh tunnels, PL/Python");
        experienceStorage.addExperience(RITCenter);

        Experience luxoft = new Experience();
        luxoft.setPlace("Luxoft (Deutsche Bank)");
        luxoft.setDates(YearMonth.of(2010, 12), YearMonth.of(2012, 4));
        luxoft.setTitle("Ведущий программист");
        luxoft.setDescription("Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, " +
                "GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. " +
                "Реализация RIA-приложения для администрирования, мониторинга и анализа результатов " +
                "в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, " +
                "Commet, HTML5.");
        experienceStorage.addExperience(luxoft);

        Experience yota = new Experience();
        yota.setPlace("Yota");
        yota.setDates(YearMonth.of(2008, 6), YearMonth.of(2010, 12));
        yota.setTitle("Ведущий специалист");
        yota.setDescription("Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" " +
                "(GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). " +
                "Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента " +
                "(Python/ Jython, Django, ExtJS)");
        experienceStorage.addExperience(yota);

        Experience enkata = new Experience();
        enkata.setPlace("Enkata");
        enkata.setDates(YearMonth.of(2008, 6), YearMonth.of(2010, 12));
        enkata.setTitle("Разработчик ПО");
        enkata.setDescription("Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) " +
                "частей кластерного J2EE приложения (OLAP, Data mining).");
        experienceStorage.addExperience(enkata);

        Experience siemens = new Experience();
        siemens.setPlace("Siemens AG");
        siemens.setDates(YearMonth.of(2005, 1), YearMonth.of(2007, 2));
        siemens.setTitle("Разработчик ПО");
        siemens.setDescription("Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО " +
                "на мобильной IN платформе Siemens @vantage (Java, Unix).");
        experienceStorage.addExperience(siemens);

        Experience alcatel = new Experience();
        alcatel.setPlace("Alcatel");
        alcatel.setDates(YearMonth.of(1997, 9), YearMonth.of(2005, 1));
        alcatel.setTitle("Инженер по аппаратному и программному тестированию");
        alcatel.setDescription("Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).");
        experienceStorage.addExperience(alcatel);

        resume.sections.put(EXPERIENCE, experienceStorage);

        ExperienceStorage educationStorage = new ExperienceStorage();

        Experience coursera = new Experience();
        coursera.setPlace("Coursera");
        coursera.setDates(YearMonth.of(2013, 3), YearMonth.of(2013, 5));
        coursera.setTitle("\"Functional Programming Principles in Scala\" by Martin Odersky");
        educationStorage.addExperience(coursera);

        Experience luxoftEducation = new Experience();
        luxoftEducation.setPlace("Luxoft");
        luxoftEducation.setDates(YearMonth.of(2011, 3), YearMonth.of(2011, 4));
        luxoftEducation.setTitle("Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"");
        educationStorage.addExperience(luxoftEducation);

        Experience siemensEducation = new Experience();
        siemensEducation.setPlace("Siemens AG");
        siemensEducation.setDates(YearMonth.of(2005, 1), YearMonth.of(2005, 4));
        siemensEducation.setTitle("3 месяца обучения мобильным IN сетям (Берлин)");
        educationStorage.addExperience(siemensEducation);

        Experience alcatelEducation = new Experience();
        alcatelEducation.setPlace("Alcatel");
        alcatelEducation.setDates(YearMonth.of(1997, 9), YearMonth.of(1998, 3));
        alcatelEducation.setTitle("6 месяцев обучения цифровым телефонным сетям (Москва)");
        educationStorage.addExperience(alcatelEducation);

        Experience university2 = new Experience();
        university2.setPlace("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики");
        university2.setDates(YearMonth.of(1993, 9), YearMonth.of(1996, 7));
        university2.setTitle("Аспирантура (программист С, С++)");
        educationStorage.addExperience(university2);

        Experience university1 = new Experience();
        university1.setPlace("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики");
        university1.setDates(YearMonth.of(1987, 9), YearMonth.of(1993, 7));
        university1.setTitle("Инженер (программист Fortran, C)");
        educationStorage.addExperience(university1);

        resume.sections.put(EDUCATION, educationStorage);


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
