<#include '/include/header.ftl'>

<h1>ПЛАГИН</h1>

<h2>ПОДКЛЮЧЕНИЕ MAVEN-ПЛАГИНА ДЛЯ ПРИЛОЖЕНИЯ</h2>

<pre style="background-color: #E0E0E0; border: 1px solid black; padding: 20px;">

&lt;project ...&gt;

    &lt;modelVersion&gt;4.0.0&lt;/modelVersion&gt;

    &lt;groupId&gt;com.example/groupId&gt;
    &lt;artifactId&gt;my-app&lt;/artifactId&gt;
    &lt;version&gt;1.0.0&lt;/version&gt;

    ...

    &lt;build&gt;
        &lt;plugins&gt;
            &lt;plugin&gt;
                &lt;groupId&gt;org.jacoco&lt;/groupId&gt;
                &lt;artifactId&gt;jacoco-maven-plugin&lt;/artifactId&gt;
                &lt;version&gt;0.8.14&lt;/version&gt;
                &lt;executions&gt;
                    &lt;execution&gt;
                        &lt;goals&gt;
                            &lt;goal&gt;prepare-agent&lt;/goal&gt;
                        &lt;/goals&gt;
                    &lt;/execution&gt;
                    &lt;execution&gt;
                        &lt;id&gt;report&lt;/id&gt;
                        &lt;phase&gt;prepare-package&lt;/phase&gt;
                        &lt;goals&gt;
                            &lt;goal&gt;report&lt;/goal&gt;
                        &lt;/goals&gt;
                    &lt;/execution&gt;
                &lt;/executions&gt;
            &lt;/plugin&gt;
            &lt;plugin&gt;
                &lt;groupId&gt;ru.volnenko.plugin&lt;/groupId&gt;
                &lt;artifactId&gt;jacocohub-maven-plugin&lt;/artifactId&gt;
                &lt;version&gt;1.0.0&lt;/version&gt;
                &lt;configuration&gt;
                    &lt;jacocohub&gt;http://localhost:8080&lt;/jacocohub&gt;
                    &lt;type&gt;APPLICATION&lt;/type&gt;
                    &lt;branch&gt;master&lt;/branch&gt;
                &lt;/configuration&gt;
            &lt;/plugin&gt;
        &lt;/plugins&gt;
    &lt;/build&gt;

    ...

&lt;/project&gt;

</pre>

<h2>ПОДКЛЮЧЕНИЕ MAVEN-ПЛАГИНА ДЛЯ БИБЛИОТЕКИ</h2>

<pre style="background-color: #E0E0E0; border: 1px solid black; padding: 20px;">

&lt;project ...&gt;

    &lt;modelVersion&gt;4.0.0&lt;/modelVersion&gt;

    &lt;groupId&gt;com.example/groupId&gt;
    &lt;artifactId&gt;my-lib&lt;/artifactId&gt;
    &lt;version&gt;1.0.0&lt;/version&gt;

    ...

    &lt;build&gt;
        &lt;plugins&gt;
            &lt;plugin&gt;
                &lt;groupId&gt;org.jacoco&lt;/groupId&gt;
                &lt;artifactId&gt;jacoco-maven-plugin&lt;/artifactId&gt;
                &lt;version&gt;0.8.14&lt;/version&gt;
                &lt;executions&gt;
                    &lt;execution&gt;
                        &lt;goals&gt;
                            &lt;goal&gt;prepare-agent&lt;/goal&gt;
                        &lt;/goals&gt;
                    &lt;/execution&gt;
                    &lt;execution&gt;
                        &lt;id&gt;report&lt;/id&gt;
                        &lt;phase&gt;prepare-package&lt;/phase&gt;
                        &lt;goals&gt;
                            &lt;goal&gt;report&lt;/goal&gt;
                        &lt;/goals&gt;
                    &lt;/execution&gt;
                &lt;/executions&gt;
            &lt;/plugin&gt;
            &lt;plugin&gt;
                &lt;groupId&gt;ru.volnenko.plugin&lt;/groupId&gt;
                &lt;artifactId&gt;jacocohub-maven-plugin&lt;/artifactId&gt;
                &lt;version&gt;1.0.0&lt;/version&gt;
                &lt;configuration&gt;
                    &lt;jacocohub&gt;http://localhost:8080&lt;/jacocohub&gt;
                    &lt;type&gt;LIBRARY&lt;/type&gt;
                    &lt;branch&gt;master&lt;/branch&gt;
                &lt;/configuration&gt;
            &lt;/plugin&gt;
        &lt;/plugins&gt;
    &lt;/build&gt;

    ...

&lt;/project&gt;

</pre>

<#include '/include/footer.ftl'>