package com.sunnyportfoliowebsite.backend.repository;

import com.sunnyportfoliowebsite.backend.model.blog.PortfolioItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PortfolioItemRepository extends JpaRepository<PortfolioItem, Long> {
    Optional<PortfolioItem> findBySlug(String slug);

    @Query(
            value = "SELECT * FROM portfolio_items WHERE content_tsv @@ to_tsquery('english', :query)",
            nativeQuery = true
    )
    List<PortfolioItem> searchByQuery(String query);

    @Query(
            value = "SELECT p.* FROM portfolio_items p " +
                    "LEFT JOIN portfolio_item_tags pit ON p.id = pit.portfolio_item_id " +
                    "LEFT JOIN tags t ON pit.tag_id = t.id " +
                    "WHERE (:type IS NULL OR p.type = :type) " +
                    "AND ((COALESCE(:tags) IS NULL) OR t.name IN (:tags)) " +
                    "GROUP BY p.id " +
                    "HAVING (COALESCE(:tags) IS NULL OR COUNT(DISTINCT t.name) = :tagCount) " +
                    "ORDER BY p.order_appears ASC, p.publication_date DESC",
            nativeQuery = true
    )
    List<PortfolioItem> filterItems(String type, List<String> tags, long tagCount);
}
