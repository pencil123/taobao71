package com.taobao71.tb71.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {
    //队列 起名：TestDirectQueue
    //自动装配 RabbitMQ 的链接工厂实例
    @Autowired
    private CachingConnectionFactory connectionFactory;
    //自动装配消息监听器所在的容器工厂配置类实例
    @Autowired
    private SimpleRabbitListenerContainerFactoryConfigurer factoryConfigurer;

    static Logger logger = LoggerFactory.getLogger(RabbitmqConfig.class);

    @Bean
    public Queue DirectQueue() {
        // durable:是否持久化,默认是false,持久化队列：会被存储在磁盘上，当消息代理重启时仍然存在，暂存队列：当前连接有效
        // exclusive:默认也是false，只能被当前创建的连接使用，而且当连接关闭后队列即被删除。此参考优先级高于durable
        // autoDelete:是否自动删除，当没有生产者或者消费者使用此队列，该队列会自动删除。
        //   return new Queue("TestDirectQueue",true,true,false);

        //一般设置一下队列的持久化就好,其余两个就是默认false
        return new Queue("tkQueue",true,false,false);
    }

    //Direct交换机 起名：TestDirectExchange
    @Bean
    DirectExchange DirectExchange() {
        //  return new DirectExchange("TestDirectExchange",true,true);
        return new DirectExchange("tkExchange",true,false);
    }

    //绑定  将队列和交换机绑定, 并设置用于匹配键：TestDirectRouting
    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(DirectQueue()).to(DirectExchange()).with("tk");
    }

    @Bean
    DirectExchange lonelyDirectExchange() {
        return new DirectExchange("lonelyDirectExchange");
    }


    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory defaultConnectionFactory){
        return new RabbitAdmin(defaultConnectionFactory);
    }

    /**
     * 设置生产者的生产消息的ack信息回调(公共处理)
     */
    @Bean
    public RabbitTemplate.ConfirmCallback confirmCallback(){
        return (correlationData, ack, cause)->{
            //我们可以通过correlationData原始数据 来对消息进行后续处理，但是这是有个要求在于发送必须使用CorrelationData类
            if(ack){
                logger.info("消息发送成功!!!!!,消息data:{}，时间:{}",correlationData,System.currentTimeMillis());
            }else {
                logger.error("消息发送失败!!!!,原因是:{}",cause);
            }
        };
    }

    /**
     * 发送者失败通知
     */
    @Bean
    public RabbitTemplate.ReturnCallback returnCallback(){
        //构建一个
        return (Message message, int replyCode, String replyText, String exchange, String routingKey)->{
            logger.error("发送者路由失败，请检查路由 Returned replyCode:{} Returned replyText:{} Returned routingKey:{} Returned message:{}"
                    ,  replyCode,replyText,routingKey,new String(message.getBody()));
        };
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
/*      // 可以在配置项中设置，或者在实例中设置。
        //若使用confirm-callback ，必须要配置publisherConfirms 为true
        connectionFactory.setPublisherConfirmType(CachingConnectionFactory.ConfirmType.CORRELATED);
        //若使用return-callback，必须要配置publisherReturns为true
        connectionFactory.setPublisherReturns(true);*/
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        rabbitTemplate.setConfirmCallback(confirmCallback());
        rabbitTemplate.setReturnCallback(returnCallback());
        rabbitTemplate.setMandatory(true);
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

}
