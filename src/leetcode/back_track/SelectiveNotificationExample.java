package leetcode.back_track;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SelectiveNotificationExample {
    // ������������ʵ��
    private ReentrantLock lock = new ReentrantLock();
    // ������������
    private Condition condition = lock.newCondition();
    // ������־λ
    private boolean flag = false;

    private void waitForCondition() {
        // ��ȡ��
        lock.lock();
        try {
            // ������������ʱ
            while (!flag) {
                System.out.println("���������㣬�����ȴ��У�");
                // �ȴ��������㣬��ǰ�߳̽���ȴ�״̬���ͷ���
                condition.await();
            }
            System.out.println("�������㣬���ü����ȴ��ˣ�");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // �ͷ���
            lock.unlock();
        }
    }

    private void notifyForCondition() {
        // ��ȡ��
        lock.lock();
        try {
            // ��������Ϊ����
            flag = true;
            // ����һ���ȴ����������߳�
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // �ͷ���
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SelectiveNotificationExample example = new SelectiveNotificationExample();
        Thread thread = new Thread(() -> {
            // �����̲߳�ִ�еȴ������ķ���
            example.waitForCondition();
        });
        // �����߳�
        thread.start();
        try {
            // ���̵߳ȴ�10�룬ģ�������ı���ӳ�
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // ��������������ź�
        example.notifyForCondition();
    }
}