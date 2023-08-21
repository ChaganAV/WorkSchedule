# Дипломный проект
* Учебное заведение: GeekBrains
* Курс: ИТ-инженер Передовые технологии Пакет Базовый
* Специализация: Разработчик
* Тема проекта: Исследование языка программирования Java и стека технологий на примере создания веб-приложения для ведения графиков работ в производственных условиях
* ФИО: Чаган Александр Владимирович
* Место и год написания: г. Тольятти, 2023 год

## Тема проекта: Исследование языка программирования Java и стека технологий на примере создания веб-приложения для ведения графиков работ в производственных условиях

## Цель: Изучить особенности объектно-ориентированного языка программирования Java и сопутствующих ему технологий для реализации веб-приложения.

## Оглавление
* [Задачи](#задачи)
* [Инструменты](#инструменты)
* [Техническое задание](#техзадание)
* [Структура приложения](#структура-приложения)
* [Примерный внешний вид](#примерный-внешний-вид)
* [Стек технологий](#стек-технологий)
* [Введение](#введение)
* [Глава 1. Язык написания приложения Java](#глава-1-язык-написания-приложения-java)
* [Глава 2. Серверная часть проекта](#глава-2-серверная-часть-проекта)
* [Глава 3. Клиентская часть проекта](#глава-3-клиентская-часть-проекта)
* [Глава 4. База данных MySQL](#глава-4-база-данных-mysql)
* [Глава 5. Git, GitHub, GitLab](#глава-5-git-github-gitlab)
* [Заключение](#заключение)

## Задачи:
* Изучить литературу по теме исследования
* Рассмотреть основные приемы ООП
* Ознакомится и поработать с синтаксисом языка программирования Java
* Освоить навыки работы с прикладными инструментами для построения веб-приложений
* Ознакомится со стеком технологий на стороне клиента: CSS/HTML/JS
* Ознакомится со стеком технологий на стороне сервера: nginx, apache, tomcat
* Построить веб-приложение для ведения Графиков работы в производственной сфере
* Настроить интеграцию с внешним приложением

## Инструменты:
* IntelliJ Idea
* Git
* GitHab/GitLab

## Техзадание


## Структура приложения
* веб-интерфейс
* веб-сервер
* база данных
* интеграция с внешней базой данных

## Примерный внешний вид
* общий вид
![график работы](./schedule.png)
*
* вид за период
![вид в рабочем режиме](./schedule-period.png)

## Стек технологий
* Язык Java - как основа серверной части
* Spring, Spring Boot - для упрощения написания серверной части
* База данных MySQL - для хранения данных приложения
* База данных Oracle - данные внешнего приложения
* CSS/HTML - написание браузерной части
* Сервер с ОС Linux
* Веб-сервер nginx - для обработки статических файлов
* Веб-сервер apache - для обработки динамических сведений приложения
* Git - для сохранения приложения на этапах разработки
* GitHub - для дальнейшего опубликования 

## Введение

* Веб-приложение для заполнения графика работы и передачи сведений в базу данных расчетного отдела (oracle)
Разработка является дополнительным сервисом к основной программе. 
* 
* Задача, которую предстоит решить возникла глядя на то, как сотрудники учреждения
в разных отделениях в файле Excel или LibreOffice заполняют графики работы сотрудников,
распечатывают из на бумагу, подписывают и затем отдают подписанный бланк расчетчикам.
Те в свою очередь, вносят эти сведения в программу Парус 8. И эта последняя часть ложится
на плечи и без того загруженных бухгалтеров-расчетчиков.
*
* Какие есть варианты, чтобы упростить работу.
  * Купить дополнительный модуль с количеством лицензий на всех старших по отделениям (не маленькие деньги)
  * Написать веб-приложение, в которое старшие в отделениях будут вносить сведения в графики на сотрудников. И после подписания, могли бы отправить в базу Бухгалтерии.
    Я остановился на втором варианте.

## Глава 0. Проектирование задачи

1. **База данных**. При проектировании возникли вопросы. Использовать имеющуюся базу, в которой работает бухгалтерия, это 
   база Oracle Database 11. Или сделать приложение более независимым и расположить объекти хранящиеся в базе, 
   такие как таблицы, в отдельной базе, например MySQL. В случае выбора первого варианта, хранить промежуточные 
   сведения в основной базе (oracle), отпадает необходимость разворачивать базу MySQL, достаточно создать 
   необходимые таблицы (table) или представления (view). Плюс в этом, что большинство информации по  
   сотрудникам в отделении, сами отделения уже есть, остается создать таблицы для хранения графиков. 
   Но появляется большая зависимость от работы расчетного отдела, по организации сотрудников в отделениях 
   и прочее
   В случае второго варианта, использования отдельной базы, придется какое-то количество информации 
   либо дублировать, либо структурировать под свои нужды, при этом сама работа ответственных в отделениях 
   не будет сильно привязана к расчетному отделу. В тоже время, если например, если бухгалтерия 
   решит однажды перейти на другую базу, например PostgreSql, в рамках импортозамещения, в чем есть  
   вероятность, то это не сильно скажется на текущей работе разрабатываемого приложения. Его логика 
   останется неизменной, оно продолжит реализовывать свою задачу, останется лишь немного откорректировать 
   строку соединения, и возможно что-то еще.
2. **Spring**. Для реализации веб-приложения воспользуюсь фреймворком Spring, а именно проектом экосистемы Spring,
который называется Spring Boot. Такой вариант очень подходит, поскольку при умении пользоваться фреймворком 
Spring, он значительно упрощает создание веб-приложений. 
3. **Веб-приложение**. В общих чертах, из чего состоит веб-приложение:
  * клиентская часть - то, с чем непосредственно взаимодействует пользователь. Эта часть представлена 
    браузером. Браузер отправляет запросы на веб-сервер, получает от него ответы и предоставляет пользователю
    способ взаимодействия с приложением. Клиентскую часть еще называют фронтендом.
  * серверная часть - получает запросы от клиента и отправляет ему в ответ данные. Серверная часть содержит
    логику, которая обрабатывает и может сохранять запрашиваемые клиентом данные перед тем, как отправить ему ответ.
    Серверную часть также называют бэкендом.
4. **Инициализация проекта**. Чтобы создать проект с нуля воспользуемся сервисом инициализации проекта для создания проекта Spring Boot. Для
этого перейдем на сайт https://start.spring.io, укажем свойства проекта, а именно:
  * в разделе Project выберем Maven
  * в разделе Language выберем язык програмирования Java
  * в разделе Spring boot выберем версию из предложенных, 3.1.0
  * в разделе Project Metadata в Artifact и Name внесем наименование проекта, наш проект будет называться WorkSchedule, 
    также укажем версию Java, у нас 17
  * и в разделе Dependencies укажем зависимости. Из тех которые для нас очевидны это 
    * spring-boot-starter-thymeleaf - 
    * spring-boot-starter-web
  
  * Для обработки передачи и получения HTTP-запросов нам также понадобится контейнер сервлетов, его еще 
  называют веб-сервером. Одним из популярных контейнеров сервлетов считается Tomcat
5. **Техническое задание**. При реализации задачи, сразу же столкнулся с отсутствием проекта, то есть технического задания.
Определение сущностей. Начну с того, что видит пользователь, с чем он работает:
  * Заголовок
    * Подразделение
    * ФИО сотрудника
    * Период
  * Спецификация
    * Категории дней
    * Таблица дней за период

## Глава 1. Язык написания приложения Java

## Глава 2. Серверная часть проекта

## Глава 3. Клиентская часть проекта

1. **Внешний вид**. Для придания внешнего вида воспользуемся уже написанными технологиями. Использую Bootstrap.
   * На сайте getbootstrap.com переходим в раздел Docs. 
   * Смотрим раздел быстрый старт Quick start. 
   * Здесь пункт 1 и 2, на примере создания файла index.html следует обратить внимание на две строки, 
   link и script. 
     * Первую включаем в наш файл в разделе head, это ссылка на файлы css от bootstrap,
     * Вторую вконец раздела body в конец тела body, это скрипты js. В конец раздела body, чтобы скрипты подгрузились после загрузки всей страницы,
     это создаст видимость более быстрой загрузки страницы.
2. **Компоненты**. В меню слева можем выбирать компоненты и смотреть по ним информацию.
   * Containers. Как указано в инструкции, это фундаментальный блок Bootstrap, в котором может содержатся контент

## Глава 4. База данных MySQL

## Глава 5. Git, GitHub, GitLab

## Заключение