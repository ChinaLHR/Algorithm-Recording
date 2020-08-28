package io.github.chinalhr.leetcode.medium.design;

import com.google.common.base.Preconditions;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lihanrong
 * @Date: 2020/8/27 3:25 下午
 * @Description: 题目: 146. LRU缓存机制
 * <p>
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * 分析:
 * LRU 缓存器，LRU是Least Recently Used的简写，就是最近最少使用的意思。
 * get函数：通过输入 key 来获得 value，如果成功获得后，这对 (key, value) 升至缓存器中最常用的位置（顶部），如果 key 不存在，则返回 -1 。
 * put函数：
 * 容量未满情况：插入一对新的 (key, value)，如果原缓存器中有该 key，则需要先删除掉原有的，将新的插入到缓存器的顶部。如果不存在，则直接插入到顶部。
 * 容量已满情况：需要删掉一个最不常用的值，也就是底部的值。
 * <p>
 * 实现:
 * 【哈希表+双向链表】
 * 双向链表按照被使用的顺序存储了这些键值对，靠近头部的键值对是最近使用的，而靠近尾部的键值对是最久未使用的。
 * 哈希表即为普通的哈希映射（HashMap），通过缓存数据的键映射到其在双向链表中的位置。
 * 首先使用哈希表进行定位，找出缓存项在双向链表中的位置，随后将其移动到双向链表的头部，即可在 O(1) 的时间内完成 get 或者 put 操作。
 * 注意：可以使用一个伪头部（dummy head）和伪尾部（dummy tail）标记界限，这样在添加节点和删除节点的时候就不需要检查相邻的节点是否存在。
 */
public class LRUCache {

    static class LinkedNode {
        int key;
        int value;
        LinkedNode prev;
        LinkedNode next;

        public LinkedNode() {
        }

        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, LinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private LinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 获取缓存
     *
     * @param key
     * @return
     */
    public int get(int key) {
        LinkedNode node = cache.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    /**
     * 添加缓存
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        LinkedNode node = cache.get(key);
        //如果缓存已经存在，更新缓存
        if (node != null) {
            node.value = value;
            moveToHead(node);
            return;
        }
        //创建一个新节点，添加到HashMap、链表头部
        LinkedNode newNode = new LinkedNode(key, value);
        cache.put(key, newNode);
        addToHead(newNode);
        size++;
        //判断是否超过容量
        if (size > capacity) {
            LinkedNode tailNode = removeTail();
            cache.remove(tailNode.key);
            size--;
        }
    }

    private void moveToHead(LinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(LinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(LinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private LinkedNode removeTail() {
        LinkedNode lastNode = tail.prev;
        removeNode(lastNode);
        return lastNode;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        Preconditions.checkArgument(cache.get(1) == 1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得key 2 作废
        Preconditions.checkArgument(cache.get(2) == -1);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        Preconditions.checkArgument(cache.get(1) == -1);       // 返回 -1 (未找到)
        Preconditions.checkArgument(cache.get(3) == 3);       // 返回  3
        Preconditions.checkArgument(cache.get(4) == 4);       // 返回  4
    }
}
