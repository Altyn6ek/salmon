**Добро пожаловать в решение для тестового задания от компании salmon!
Оба задания реализованы в виде тестовых классов: TestJsonPlaceholder и TestPosts сооветственно. 
Для второго задания решение выводил в консоль (видно будет если запускать тесты вручную), так же ответ будет отображаться в отчете в виде приложения к тесту.**

# Инструкция для mac OS
## Предусловия: 
1. Устновлена JAVA - JDK 21 https://www.oracle.com/java/technologies/downloads/?er=221886#jdk21-mac 
можно используя homebrew
` /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"`

И далее с его помощью установить JAVA

`brew update`

`brew install openjdk@2`

2. Настроены переменные окружения - после установки вам нужно будет указать системе, что именно вы хотите использовать Java 21 по умолчанию. Добавьте следующие строки в ваш файл конфигурации оболочки (например, .zshrc или .bash_profile)

`export JAVA_HOME=$(/usr/libexec/java_home -v 21)
export PATH=$JAVA_HOME/bin:$PATH`

## Шаги:
1. Склонировать проект
2. Из папки проекта ввести команду `./gradlew test`
3. По завершению выполнения тестов ввести команду `./gradlew allureReport` для создания отчета
4. Для того, чтобы просмотреть отчет, ввести команду `./gradlew allureReport`

# Инструкция для Windows
## Предусловия: 
1. Скачайте установочный файл Java
Перейдите на официальный сайт Java от Oracle JDK 21 https://www.oracle.com/java/technologies/downloads/?er=221886#jdk21-windows
Cкачайте установочный файл для Windows. Удобно если это будет файл с расширением .exe.
2. Установите Java
Дважды щелкните на скачанный установочный файл, чтобы начать установку.
Следуйте инструкциям мастера установки. Вы можете выбрать стандартный путь установки или указать свой собственный. Обычно по умолчанию Java устанавливается в папку C:\Program Files\Java\jdk-21.
Завершите установку, нажав "Finish" или "Закончить".
3. Настройте переменные окружения
Откройте меню Пуск и введите "Системные переменные" и выберите "Изменение системных переменных".
В открывшемся окне "Свойства системы" нажмите кнопку "Переменные среды".
Найдите переменную PATH в списке системных переменных и выберите ее, затем нажмите "Изменить".
Добавьте путь к папке bin внутри каталога установки Java. 
Например:
> C:\Program Files\Java\jdk-21\bin

Нажмите "ОК", чтобы сохранить изменения.
Создайте новую системную переменную JAVA_HOME:
Нажмите "Создать" в разделе системных переменных.
Введите JAVA_HOME в поле "Имя переменной".
В поле "Значение переменной" укажите путь к каталогу установки JDK, 
Например:
> C:\Program Files\Java\jdk-21

Нажмите "ОК", чтобы сохранить переменную.

## Шаги:
1. Склонировать проект
2. Из папки проекта ввести команду `./gradlew test`
3. По завершению выполнения тестов ввести команду `./gradlew allureReport` для создания отчета
4. Для того, чтобы просмотреть отчет, ввести команду `./gradlew allureReport`
