-- GIN = Generalised inverted index
-- Allows basically faster text searching
CREATE INDEX IF NOT EXISTS content_tsv_idx ON portfolio_items USING GIN(content_tsv);

-- Combines the title (higher weight) with the content as well in the markdown file (lower weight)
CREATE OR REPLACE FUNCTION update_portfolio_item_tsv() RETURNS trigger AS $$
BEGIN
    NEW.content_tsv :=
            setweight(to_tsvector('pg_catalog.english', coalesce(NEW.title,'')), 'A') ||
            setweight(to_tsvector('pg_catalog.english', coalesce(NEW.content_markdown,'')), 'B');
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Trigger to update the vector every time it's changed (for searching)
DROP TRIGGER IF EXISTS tsvector_update ON portfolio_items;
CREATE TRIGGER tsvector_update
BEFORE INSERT OR UPDATE ON portfolio_items
FOR EACH ROW EXECUTE FUNCTION update_portfolio_item_tsv();