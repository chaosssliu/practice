#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.config;import org.springframework.context.annotation.*;import org.springframework.transaction.annotation.EnableTransactionManagement;@Configuration@EnableTransactionManagement@ImportResource("classpath:activiti-context.xml")public class ActivitiConfig {}