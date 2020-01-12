package model

/**
 * Case class representing an article retrieved from getpocket.com
 *
 * @param itemId - A unique identifier matching the saved item. This id must be used to perform any actions through the v3/modify endpoint.
 * @param resolvedId - A unique identifier similar to the item_id but is unique to the actual url of the saved item. The resolved_id identifies unique urls. For example a direct link to a New York Times article and a link that redirects (ex a shortened bit.ly url) to the same article will share the same resolved_id. If this value is 0, it means that Pocket has not processed the item. Normally this happens within seconds but is possible you may request the item before it has been resolved.
 * @param givenUrl - The actual url that was saved with the item. This url should be used if the user wants to view the item.
 * @param resolvedUrl - The final url of the item. For example if the item was a shortened bit.ly link, this will be the actual article the url linked to.
 * @param givenTitle - The title that was saved along with the item.
 * @param resolvedTitle - The title that Pocket found for the item when it was parsed
 * @param favourite - 0 or 1 - 1 If the item is favourited
 * @param status - 0, 1, 2 - 1 if the item is archived - 2 if the item should be deleted
 * @param excerpt - The first few lines of the item (articles only)
 * @param isArticle - 0 or 1 - 1 if the item is an article
 * @param hasImage - 0, 1, or 2 - 1 if the item has images in it - 2 if the item is an image
 * @param hasVideo - 0, 1, or 2 - 1 if the item has videos in it - 2 if the item is a video
 * @param wordCount - How many words are in the article
 * @param tags - A JSON object of the user tags associated with the item
 * @param authors - A JSON object listing all of the authors associated with the item
 * @param images - A JSON object listing all of the images associated with the item
 * @param videos - A JSON object listing all of the videos associated with the item
 */
case class Article(
                    itemId: Int,
                    resolvedId: Int,
                    givenUrl: String,
                    resolvedUrl: String,
                    givenTitle: String,
                    resolvedTitle: String,
                    favourite: Int,
                    status: Int,
                    excerpt: String,
                    isArticle: Int,
                    hasImage: Int,
                    hasVideo: Int,
                    wordCount: Int,
                    tags: Seq[Tag],
                    authors: Seq[Author],
                    images: Seq[Image],
                    videos: Seq[Video]
                  )
