package ru.shbr.ya_lavka2023.service.impl;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * Класс, представляющий запрос на постраничную выдачу заказов.
 * <p>
 * Этот класс реализует интерфейс {@link Pageable} и используется для передачи информации о смещении (offset),
 * количестве записей на странице (limit) и порядке сортировки (sort).
 */
public class OrderPaginationRequest implements Pageable {
    /**
     * Смещение для постраничной выдачи
     */
    private final Integer offset;
    /**
     * Количество записей для постраничной выдачи
     */
    private final Integer limit;
    /**
     * Порядок сортировки на странице
     */
    private final Sort sort;

    /**
     * Конструктор для создания запроса на постраничную выдачу заказов.
     *
     * @param offset смещение для постраничной выдачи
     * @param limit  количество записей на странице
     * @param sort   порядок сортировки
     */
    public OrderPaginationRequest(Integer offset, Integer limit, Sort sort) {
        this.offset = offset;
        this.limit = limit;
        this.sort = sort;
    }

    /**
     * Возвращает номер страницы (всегда 0 для данного запроса).
     *
     * @return номер страницы
     */
    @Override
    public int getPageNumber() {
        return 0;
    }

    /**
     * Возвращает количество записей на странице.
     *
     * @return количество записей на странице
     */
    @Override
    public int getPageSize() {
        return limit;
    }

    /**
     * Возвращает смещение для постраничной выдачи.
     *
     * @return смещение
     */
    @Override
    public long getOffset() {
        return offset;
    }

    /**
     * Возвращает порядок сортировки.
     *
     * @return объект {@link Sort}, определяющий порядок сортировки
     */
    @Override
    public Sort getSort() {
        return sort;
    }

    /**
     * Возвращает следующий {@link Pageable}.
     *
     * @return следующий {@link Pageable}, или {@code null}, если не поддерживается
     */
    @Override
    public Pageable next() {
        return null;
    }

    /**
     * Возвращает предыдущий или первый {@link Pageable}.
     *
     * @return предыдущий или первый {@link Pageable}, или {@code null}, если не поддерживается
     */
    @Override
    public Pageable previousOrFirst() {
        return null;
    }

    /**
     * Возвращает первый {@link Pageable}.
     *
     * @return первый {@link Pageable}, или {@code null}, если не поддерживается
     */
    @Override
    public Pageable first() {
        return null;
    }

    /**
     * Возвращает новый {@link Pageable} с указанным номером страницы.
     *
     * @param pageNumber номер страницы
     * @return новый {@link Pageable} с указанным номером страницы, или {@code null}, если не поддерживается
     */
    @Override
    public Pageable withPage(int pageNumber) {
        return null;
    }

    /**
     * Определяет, есть ли предыдущая страница.
     *
     * @return {@code false}, так как предыдущая страница не поддерживается
     */
    @Override
    public boolean hasPrevious() {
        return false;
    }
}
